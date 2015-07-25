/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haskins.cloudtrailviewer.utils;

import com.haskins.cloudtrailviewer.model.event.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mark
 */
public class ChartUtils {
    
    public static <K,V extends Comparable<? super V>>  List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries, 
            new Comparator<Map.Entry<K,V>>() {
                @Override
                public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            }
        );

        return sortedEntries;
    }
    
    public static List<Map.Entry<String,Integer>> getTopEvents(List<Event> events, int top, String chartFocus) {
        
        Map<String, Integer> eventsByOccurance = new HashMap<>();
        
        for (Event event : events) {
            
            String property = getEventProperty(chartFocus, event);

            if (property != null) {

                int count = 1;
                if (eventsByOccurance.containsKey(property)) {
                    count = eventsByOccurance.get(property);
                    count++;
                }
                eventsByOccurance.put(property, count);
            }
        }
        
        if (!eventsByOccurance.isEmpty()) {
            
            List<Map.Entry<String,Integer>> sorted = entriesSortedByValues(eventsByOccurance);
            return getTopX(sorted, top);
            
        } else {
            return null;
        }
    }
    
    private static List<Map.Entry<String,Integer>> getTopX(List<Map.Entry<String,Integer>> sorted, int top) {
        
       List<Map.Entry<String,Integer>> topEvents = new ArrayList<>();
        
        int count = top;
        if (sorted.size() < count) {
            count = sorted.size();
        }
        
        for (int i=0; i<count; i++) {
            topEvents.add(sorted.get(i));
        }
        
        return topEvents;
    }
    
    private static String getEventProperty(String property, Object event) {
        
        String requiredValue;
        
        if (property.contains(".")) {
            
            int pos = property.indexOf(".");
            String field = property.substring(0, pos);
             
            Object subClass = callMethod(field, event);
            if (subClass != null) {
                property = property.substring(pos + 1);
                return getEventProperty(property, subClass); 
            } else {
                return null;
            }
            
        } else {
            
            requiredValue = (String) callMethod(property, event);
        }
       
        return requiredValue; 
    }
    
    private static Object callMethod(String property, Object reflectionClass) {
        
        Object result;
        
        String camelCaseProperty = property.substring(0, 1).toUpperCase() + property.substring(1);
        
        try {
            String getProperty = "get" + camelCaseProperty;
            Method method = reflectionClass.getClass().getMethod(getProperty);
            
            result = method.invoke(reflectionClass);
            
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            result = null;
        }
        
        return result;
    }
}

package com.practice.jai.java;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.*;

public class TestJava
{
    public static void main(String[] args)
    {
        Map<String, Map<String, List<String>>> map = new HashMap<>();

        Map<String, List<String>> map1 = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("ListValue 1");
        map1.put("Internal Key1", list1);

        Map<String, List<String>> map2 = new HashMap<>();
        List<String> list2 = new ArrayList<>();
        list2.add("ListValue 2");
        map2.put("Internal Key2", list2);

        map.put("Map Key1", map1);
        map.put("Map Key2", map2);

        /*String jsonObject = new Gson().toJson(map);
        System.out.println(jsonObject);*/

        Map<String, Object> schemaNameSpaceMap1 = new HashMap<>();

        List<String> versionList1 = Arrays.asList("2.0.0", "2.3.0");
        Map<String, Object> schemasList1 = new HashMap<>();
        schemasList1.put("name", "Usage");
        schemasList1.put("version", versionList1);
        List<Map<String, Object>> schemas1 = new ArrayList<>();
        schemas1.add(schemasList1);
        schemas1.stream()
        schemaNameSpaceMap1.put("schemaNameSpace", "NameSpace1");
        schemaNameSpaceMap1.put("schemas", schemas1);

        Map<String, Object> schemaNameSpaceMap2 = new HashMap<>();

        List<String> versionList2 = Arrays.asList("2.2.0", "2.3.2");
        Map<String, Object> schemasList2 = new HashMap<>();
        schemasList2.put("name", "Usage2");
        schemasList2.put("version", versionList2);
        List<Map<String, Object>> schemas2 = new ArrayList<>();
        schemas2.add(schemasList2);

        schemaNameSpaceMap2.put("schemaNameSpace", "NameSpace2");
        schemaNameSpaceMap2.put("schemas", schemas2);

        List<Map<String, Object>> schemasObject = new ArrayList<>();
        schemasObject.add(schemaNameSpaceMap1);
        schemasObject.add(schemaNameSpaceMap2);


        String jsonObject2 = new Gson().toJson(schemasObject);
        System.out.println(jsonObject2);

    }
}

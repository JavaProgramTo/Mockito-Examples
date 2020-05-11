package com.javaprogramto.mockito;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

    @Test
    public void spyArrayList() {

        List<String> spyList = Mockito.spy(ArrayList.class);

        spyList.add("Hello");
        spyList.add("mockito");
        spyList.add("spy");

        System.out.println("Spy spyList : " + spyList);
        Assert.assertEquals(3, spyList.size());
    }

    @Test
    public void spyArrayListVerify() {

        List<String> spyList = Mockito.spy(ArrayList.class);

        spyList.add("Hello");
        spyList.add("mockito");
        spyList.add("spy");

        Mockito.verify(spyList).add("spy");
        Mockito.verify(spyList).add("Hello");
        Mockito.verify(spyList).add("mockito");

        Assert.assertEquals(3, spyList.size());
    }


    @Spy
    List<String> spyAnnotation = new ArrayList<>();

    @Test
    public void spyArrayListAnnotation() {

        spyAnnotation.add("Hello");
        spyAnnotation.add("mockito");
        spyAnnotation.add("spy");

        Mockito.verify(spyAnnotation).add("spy");
        Mockito.verify(spyAnnotation).add("Hello");

        Assert.assertEquals(3, spyAnnotation.size());
    }

    @Test
    public void stubSpyArrayList() {

        List<String> stubList = Mockito.spy(ArrayList.class);

        Assert.assertEquals(0, stubList.size());

        Mockito.doReturn(50).when(stubList).size();

        Assert.assertEquals(50, stubList.size());

        Mockito.doReturn(false).when(stubList).isEmpty();

        Assert.assertEquals(false, stubList.isEmpty());
    }

    @Test
    public void mockArrayList() {

        List<String> mockList = Mockito.mock(ArrayList.class);

        mockList.add("mock");

        Assert.assertEquals(1, mockList.size());
    }

    @Test
    public void spysArrayList() {

        //List<String> mockList = Mockito.spy(ArrayList.class);
        List<String> mockList = new ArrayList<>();
        Mockito.doReturn(false).when(mockList).isEmpty();
        mockList.add("mock");

        Assert.assertEquals(1, mockList.size());
    }

    }

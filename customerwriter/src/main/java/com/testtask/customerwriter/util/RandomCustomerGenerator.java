package com.testtask.customerwriter.util;

import com.testtask.customerwriter.enums.FirstName;
import com.testtask.customerwriter.enums.LastName;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCustomerGenerator {

    public static List<FirstName> firstNames = Arrays.asList(FirstName.values());
    public static List<LastName> lastNames = Arrays.asList(LastName.values());
    public static Random random = new Random();


    public static String getRandomFirstName(){
        Integer num = random.nextInt(firstNames.size());
        return firstNames.get(num).name();
    }
    public static String getRandomLastName(){
        Integer num = random.nextInt(lastNames.size());
        return lastNames.get(num).name();
    }
    public static Integer getRandomSec(){
        int minSec=5, maxSec=10;
        return (int)(Math.random()*(maxSec-minSec)+minSec);
    }
}

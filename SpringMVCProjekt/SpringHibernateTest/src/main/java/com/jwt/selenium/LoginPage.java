package com.jwt.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
    	
    	driver = new FirefoxDriver();

       

        //Put a Implicit wait

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Website

        driver.get("URL");

        // Find the element that's ID attribute is 'account'(My Account) 

       // driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td[2]/input")).click();

        // Enter Username on the element 

        driver.findElement(By.name("userName")).sendKeys("remote"); 

        // Find the element that's ID attribute is 'pwd' (Password)

        driver.findElement(By.name("password")).sendKeys("aaaaaa");

        // Now submit the form. WebDriver will find the form for us from the element 

        driver.findElement(By.name("submit")).click();

        // Print a Log In message to the screen

        System.out.println(" Login Successfully");
        driver.findElement(By.name("img2")).click();

        // Find the element that's ID attribute is 'account_logout' (Log Out)

        //driver.findElement (By.name("img104")).click();

        // Close the driver

        driver.quit();

            }

    }
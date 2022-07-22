package com.qa.pages;

import com.qa.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ToDoMVCHome {
    WebElement ToDoTextEntryBox;
    WebElement ToDoList;
    WebElement FilterAll;
    WebElement FilterActive;
    WebElement FilterCompleted;

    public ToDoMVCHome(){
        ToDoTextEntryBox = TestBase.driver.findElement(By.xpath("//input[@placeholder= 'What needs to be done?']"));
        ToDoList = TestBase.driver.findElement(By.xpath("//ul[@class= 'todo-list']"));
    }

    public void checkEmptyTextBox(){
        boolean isTextBoxEmpty = false;
        String BaseText = ToDoTextEntryBox.getText();
        if(BaseText.equalsIgnoreCase(""))
        {
            isTextBoxEmpty = true;
        }
        assertThat(isTextBoxEmpty,is(true));
    }


    public void createEntryToDoList(String strToDoItem){
        ToDoTextEntryBox.sendKeys(strToDoItem);
        ToDoTextEntryBox.sendKeys(Keys.RETURN);
    }


    public void checkItemAddedinList(String strToDoItem){
        boolean isItemAdded = false;
        try{
            isItemAdded  = ToDoList.findElement(By.xpath("//div[@label='"+strToDoItem+"']")).isDisplayed();
           }
        catch(Exception NoSuchElementException)
        {
        }
    }

    public void clickItemAddedinList(String strToDoItem) {
        boolean isItemClicked = false;
        try {
            Thread.sleep(5000);
            TestBase.driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            isItemClicked = true;
        } catch (Exception NoSuchElementException) {
        }
    }

    public void checkCompletedItem(String strToDoItem) {
        boolean isItemPresent = false;
        try {
            String strClass=  ToDoList.findElement(By.xpath("//div[@label='" + strToDoItem + "']/../../li")).getAttribute("class");
           if(strClass.equalsIgnoreCase("todo completed"))
           {
               isItemPresent = true;
           }
           } catch (Exception NoSuchElementException) {
        }
    }







}

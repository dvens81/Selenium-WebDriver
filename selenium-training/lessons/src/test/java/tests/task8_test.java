/*
package tests;

public void countries(){
        loginAdmin();
        driver.findElement(By.cssSelector("[href*='countries']")).click();
        List<WebElement> countries=driver.findElements(By.cssSelector(".row :nth-child(5) a"));
        for(int i=0;i<=countries.size()-2;i++){
        countries=driver.findElements(By.cssSelector(".row :nth-child(5) a"));
        String compareCountries=countries.get(i).getText();
        String compareCountries2=countries.get(i+1).getText();

        //System.out.print(compareCountries);
        //System.out.print(compareCountries2);
        //System.out.println();
        if(i<countries.size()){
        Assertions.assertTrue(compareCountries.compareTo(compareCountries2)< 0);
        }
        List<WebElement> zones=driver.findElements(By.cssSelector(".row td:nth-child(6)"));

        int zonesCheker=Integer.parseInt(zones.get(i).getText());
        if(zonesCheker>0){
        countries.get(i).click();
        List<WebElement> includingCountries=driver.findElements(By.cssSelector((".dataTable td:nth-child(3)")));
        for(int j=0;j<includingCountries.size()-2;j++){
        String compareIncludCountries=includingCountries.get(j).getText();
        String compareIncludCountries2=includingCountries.get(j+1).getText();

        //System.out.print(compareIncludCountries);
        //System.out.print(compareIncludCountries2);
        //System.out.println();
        if(j<=includingCountries.size()){
        Assertions.assertTrue(compareIncludCountries.compareTo(compareIncludCountries2)< 0);
        }
        }
        driver.findElement(By.cssSelector("[href*='countries']")).click();
        }
        }
        outSession();
        }*/

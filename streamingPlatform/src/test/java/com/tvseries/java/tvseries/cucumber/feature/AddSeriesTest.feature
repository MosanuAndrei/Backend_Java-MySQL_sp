@AddSeriesTest
Feature: Add Series Test

    Scenario: Change page by clicking Add Series Link
        Given I am on my React page
        When I Click on Add Series
        Then The page should change to Add Series Page

    Scenario: Add Series in DataBase
        Given I am on Add Contact Page
        When I fill the required information and click Add Series
        Then The Series should be addded
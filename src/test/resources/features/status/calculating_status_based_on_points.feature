@tag:component:ui
@issue:FH-17
Feature: Frequent Flyer status is calculated based on points

Scenario: New members should start out as Bronze members
Given Jill Smith is not a Frequent Flyer member
When she registers on the Frequent Flyer program
Then she should have a status of Bronze

Scenario Outline: Members should get status updates based on status points earned
Given a member has a status of <initialStatus>
And he has <initialStatusPoints> status points
When he earns <extraPoints> extra status points
Then he should have a status of <finalStatus>
Examples:
| initialStatus | initialStatusPoints | extraPoints | finalStatus |
| Bronze        | 0                   | 300         | Silver      |
| Silver        | 0                   | 700         | Gold        |
| Gold          | 0                   | 1500        | Platinum    |
| Bronze        | 200                 | 99          | Bronze      |
| Bronze        | 200                 | 100         | Silver      |
| Silver        | 600                 | 99          | Silver      |
| Silver        | 600                 | 100         | Gold        |
| Gold          | 1400                | 99          | Gold        |
| Gold          | 1400                | 100         | Platinum    |
| Platinum      | 2000                | 100         | Platinum    |

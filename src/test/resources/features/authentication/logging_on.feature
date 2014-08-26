Feature:
  Logging on to the 'My Flying High' web site

Background:
   Given Joe is a Frequent Flyer member
   And Joe has registered online with a password of 'secret'

Scenario: Logging on successfully
   When Joe logs on with password 'secret'
   Then he should be given access to the site



Feature: Capture the toke from browser and login to Mobile app

@demoe2eflow
Scenario Outline: Login to Mobile app 
Given Launch the portal and mobile app using <portal>
When Capture token from the browser
Given Launch the portal and mobile app using <app>
And Enter token on the Mobile App
Then close the browser or app instance

Examples:
|portal|app		 |
|web   |mobileapp|
# ChampionsLeagueApp

Welcome to the **ChampionsLeagueApp** repository! This project showcases an Android mobile application developed by **Eduardo Ribeiro** as part of an assessment for **Gymondo**.

## Overview

The **ChampionsLeagueApp** provides users with real-time standings for the UEFA Champions League. By tapping on a team's row, users can explore detailed information about each team. The data was fetched from the Football-Data API that is present in the public APIs list given in the assessment.

## Features

- **Team List**: View current standings for all teams in the competition.
- **Team Details**: Tap any team to get more information, including stadium, date founded, coach, running competitions and more.
- **Dark and Light Themes**: The UI supports both light and dark modes, following Material Design 3 guidelines.
- **Clean Architecture**: Built using Clean Architecture principles to ensure separation of concerns and maintainability.

## Tech Stack

The app is developed with a modern Android stack and adheres to industry best practices:

- **Architecture**: MVVM (Model-View-ViewModel) with use cases.
- **Dependency Injection**: Dagger-Hilt for dependency management.
- **Networking**: Retrofit for API integration with the **Football-Data API**.
- **Image Loading**: Coil for image loading from API responses.
- **JSON Serialization**: Gson to convert JSON data into Kotlin objects.
- **Navigation**: Jetpack Compose Navigation for managing in-app navigation.

## Testing

Currently, the project does not include automated testing.

## Contact

If you have any questions or feedback, feel free to reach out through eduffr97@gmail.com

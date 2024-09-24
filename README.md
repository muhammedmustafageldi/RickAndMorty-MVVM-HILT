
# Rick and Morty MVVM Application 

⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⢠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢠⣴⣾⢿⣷⣦⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡇⠀⢀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀
⠸⣿⠀⠀⠈⢻⣷⠰⠇⠀⠀⠀⠀⠀⣷⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠹⣧⠀⣾⢻⡄⠀⢀⣀⡀⢰⣤⢦⡄⢀⡇⠀⠀⢸⡇⠀⠀⠀
⠀⢿⣇⠀⢀⣾⠇⠀⡆⠀⢀⡶⠒⢸⣿⡴⠏⠀⠀⠀⢠⡄⠀⢀⠀⣾⠀⠀⠀⣿⠀⢹⢰⡿⢰⣧⢠⡞⢻⡇⢸⣧⠞⢁⣼⣥⣀⠀⠈⣷⣀⡤⠖
⠀⠈⣿⣿⣿⣁⠀⠀⢻⠀⣿⠀⠀⠀⣿⢧⡀⠀⠀⠀⡿⢧⠿⢾⣴⣇⠀⠀⢸⡟⠀⠘⢿⠁⠈⡟⠸⢧⣼⠟⢠⠉⢷⠀⢸⠀⠀⢀⣰⡿⠋⠀⠀
⠀⠀⢻⡆⠈⠛⢻⣆⠘⠀⠙⠏⠉⠀⠇⠈⢿⡄⠀⠀⠁⠈⠀⠀⠈⠉⠀⠀⢘⠃⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⠀⠸⠀⡼⠀⢀⡾⠋⠀⠀⠀⠀
⠀⠀⠘⣧⠀⠀⠀⠈⠳⡄⠀⠀⠀⠀⠀⠀⠈⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠘⠇⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠙⠀⠀⠀⠀⠀⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀

## Overview
This Android application demonstrates the use of modern Android architecture components, including MVVM (Model-View-ViewModel), Hilt for dependency injection, Room for local data storage, and Retrofit for network operations. The application fetches and displays character data from the Rick and Morty API, allowing users to explore various characters and their details.

## Features
- **MVVM Architecture**: The app follows the MVVM pattern, ensuring a clean separation of concerns between UI components and data handling.
- **Hilt for Dependency Injection**: Hilt is used to simplify dependency management, improving code modularity and testability.
- **Room Database**: Character data is stored locally using Room, allowing offline access and efficient data management.
- **Retrofit**: The app fetches data from the Rick and Morty API using Retrofit.
- **Rx Java**: Used for managing asynchronous operations.
- **Coroutines**: Implemented for asynchronous programming to simplify code and enhance readability during data retrieval and processing.
- **LiveData**: Utilizes LiveData to observe data changes and update the UI reactively.

## Screenshots

<p align="left">
<img src="https://github.com/muhammedmustafageldi/My-ScreenShots-Files/blob/main/Screnshots/RickAndMorty/rickandmorty1.png" width="240" height="506"/>
<img src="https://github.com/muhammedmustafageldi/My-ScreenShots-Files/blob/main/Screnshots/RickAndMorty/rickandmorty2.png" width="240" height="506"/> 
<img src="https://github.com/muhammedmustafageldi/My-ScreenShots-Files/blob/main/Screnshots/RickAndMorty/rickandmorty3.png" width="240" height="506"/> 
<img src="https://github.com/muhammedmustafageldi/My-ScreenShots-Files/blob/main/Screnshots/RickAndMorty/rickandmorty4.png" width="240" height="506"/> 
<img src="https://github.com/muhammedmustafageldi/My-ScreenShots-Files/blob/main/Screnshots/RickAndMorty/rickandmorty5.png" width="240" height="506"/> 
</p>

## Technologies Used
- **Kotlin**: The primary programming language for the application.
- **Android Jetpack Components**:
  - **MVVM Architecture**
  - **LiveData**
  - **Room**
  - **ViewModel**
- **Dependency Injection**: Hilt
- **Networking**: Retrofit with RxJava
- **Coroutines**: For managing asynchronous tasks.

## Project Structure
- **Fragments**: `CharactersFragment` and `DetailsFragment` for displaying character lists and details.
- **ViewModels**: `CharactersFragmentViewModel` and `DetailsFragmentViewModel` manage UI-related data in a lifecycle-conscious way.
- **Repository**: `CharacterRepository` abstracts data sources, providing a clean API for data access.
- **Data Models**: `Character` and `ApiResponse` represent the data structure used in the application.
- **SharedPreferences**: `CustomSharedPreferences` handles saving and retrieving timestamps for data freshness checks.

## Getting Started
1. **Clone the repository**:
   ```bash
   git clone https://github.com/muhammedmustafageldi/RickAndMorty-MVVM-HILT
   ```
2. **Open the project in Android Studio**.
3. **Build the project** and run it on an emulator or a physical device.

## How to Contribute
Feel free to open issues or submit pull requests for any enhancements or bug fixes.

## Contact
For inquiries or collaboration opportunities, please reach out via [muhammedmustafageldi@gmail.com].


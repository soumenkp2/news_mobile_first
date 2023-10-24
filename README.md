# News App

This Android application provides users with up-to-date news from various categories using the [News API](https://newsapi.org/). The app supports pagination, allowing users to scroll through a list of news articles. Users can also view the details of each news article, including an image, and have the option to open the news URL in a browser.

## Screenshots

![Home Screen](homescreen.png)
![Detail Screen](detailscreen.png)

## Features

- **Splash Screen:** The app displays a creative splash screen upon launch.
- **Home Screen:** Lists top headlines from various categories including Business, Entertainment, Health, Science, Sports, and Technology.
- **Category Selection:** Users can switch between news categories.
- **Pagination:** Implements pagination to load 20 news articles per page.
- **Detail Screen:** Displays detailed information about the selected news article, including an image.
- **Browser Integration:** Provides an option to open the news URL in a browser.

## Architecture

This app follows the MVVM (Model-View-ViewModel) architecture pattern. It leverages Kotlin and clean code principles to ensure readability and maintainability of the codebase.

## Libraries Used

- **Retrofit:** For making network requests and interacting with the News API.
- **Paging:** For implementing pagination and efficient loading of news articles.
- **Picasso:** For image loading and caching.

## Minimum Requirements

- **Minimum SDK Version:** 21 (Android 5.0, Lollipop)
- **Target SDK Version:** 30 (Android 11)

## How to Build

1. Clone the repository using the following command:
   git clone https://github.com/your-username/news-app.git
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical device with minimum SDK version 21 or above.

## Error Handling

The app includes robust error handling for backend services, covering API interaction exceptions and errors. Proper error messages are displayed to users in case of network issues or API failures.

## Contributing

Contributions are welcome! Feel free to fork the repository, create pull requests, and report issues if you find any.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


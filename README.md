# DataFelix

![DataFelix Logo](https://github.com/images/logos/dataflix_logo.png)

## 📑 Overview

DataFelix is a full-featured web application for browsing movies and TV series. Built with Spring Boot, Thymeleaf, and Bootstrap, it provides a responsive and intuitive interface for users to explore and interact with their favorite media content.

## ✨ Features

- **Comprehensive Media Catalog**: Browse a diverse collection of movies and TV series
- **Detailed Information**: View comprehensive details for each title including descriptions, ratings, duration, and age requirements
- **User Authentication**: Secure login and registration system
- **Favorites System**: Add movies and series to your favorites list
- **Responsive Design**: Fully responsive interface that works on desktop and mobile devices
- **Search Functionality**: Easily find titles across the entire catalog

## 🛠️ Technologies

- **Backend**: Spring Boot 3.4.5, Java 17
- **Frontend**: Thymeleaf, Bootstrap 5, HTML5, CSS3, JavaScript
- **Database**: JPA/Hibernate with relational database
- **Security**: Spring Security for authentication and authorization
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL/PostgreSQL database

## 🚀 Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/DataFelix.git
   cd DataFelix
   ```

2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/dataflix
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application:
   ```
   http://localhost:8080
   ```

## 📝 Usage

### Browsing Movies and Series

- Navigate to the home page to see featured movies and series
- Use the navigation menu to browse different categories
- Click on a title card to view detailed information

### User Account

- Register for a new account or log in with existing credentials
- Access your profile to view and edit personal information
- View your favorites list

### Adding to Favorites

- Click the star icon on any movie or series card to add it to your favorites
- Access your favorites through the profile menu
- Remove items from favorites by clicking the star icon again

## 🔧 Common Issues and Fixes

### Thymeleaf Template Errors

If you encounter Whitelabel Error Pages related to Thymeleaf templates, check for:
- Proper syntax in template expressions
- Valid model attributes being passed to templates
- Correct HTML structure

### Data Loading Issues

If media descriptions or images aren't loading:
- Verify database connectivity
- Check that the DescriptionUpdater is functioning correctly
- Ensure proper file paths for images

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Contributors

- [Your Name](https://github.com/yourusername) - Initial work and development

## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- Bootstrap team for the responsive design components
- All open source contributors whose libraries are used in this project

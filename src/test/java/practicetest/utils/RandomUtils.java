package practicetest.utils;

import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            fullName = getRandomFullName(),
            userEmail = getRandomUserEmail(),
            gender = getRandomGender(),
            userNumber = getRandomUserNumber(),
            year = getRandomYear(),
            month = getRandomMonth(),
            hobby = getRandomHobby(),
            subject = getRandomSubject(),
            image = "image.png",
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            day = getRandomDay();

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomFirstName() {

        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {

        return new Faker().name().lastName();
    }
    public static String getRandomFullName() {

        return new Faker().name().fullName();
    }

    public static String getRandomUserEmail() {

        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return new Faker().options().option(genders);
    }

    public static String getRandomUserNumber() {

        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomYear() {

        return new Faker().random().nextInt(2000, 2023).toString();
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(months);
    }

    public static String getRandomDay() {
        int day = getRandomInt(1, 31);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Economics", "English", "Commerce", "Computer Science", "Physics",
                "Maths", "Hindi", "History", "Social Studies"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobby);
    }

    public static String getRandomAddress() {

        return new Faker().address().cityName();
    }

    public static String getRandomState() {
        String[] states = {"Rajasthan", "NCR", "Uttar Pradesh", "Haryana"};
        return new Faker().options().option(states);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana": {
                String[] city = {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan": {
                String[] city = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
        }
        return null;
    }
}


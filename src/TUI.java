import java.time.Year;
import java.util.ArrayList;

import entities.Computer;
import entities.Laptop;
import entities.PersonalComputer;
import entities.Tablet;

/**
 * Класс тектового интерфейса
 */
public class TUI {

    private enum Commands {
        ADD_DEVICE, DELETE_DEVICE, PRINT_ALL_DEVICES, COMPARE_DEVICES, EXIT
    }

    private enum Devices {
        COMPUTER, PERSONAL_COMPUTER, LAPTOP, TABLET, EXIT
    }

    /**
     * Метод меню, выполняющийся при начале работы
     */
    public static void start() {
        ArrayList<Computer> list = new ArrayList<>();
        int userChoice;
        Commands command;
        do {
            menuOutput();
            userChoice = Input.intInput();
            try {
                command = Commands.values()[userChoice - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Использована неизвестная команда");
                continue;
            }

            switch (command) {
                case ADD_DEVICE -> chooseCreateMode(list);
                case DELETE_DEVICE -> deleteComputer(list);
                case PRINT_ALL_DEVICES -> printAllComputers(list);
                case COMPARE_DEVICES -> compareComputers(list);
                case EXIT -> System.out.println("Выход из программы.");
            }
        } while (userChoice != 5);
    }

    /**
     * Метод для выбора режима создания 1 - с заполнением полей 2 - с полями по умолчанию
     *
     * @param list список с устройствами
     */
    private static void chooseCreateMode(ArrayList<Computer> list) {
        int useruserChoice;
        createInfo();
        do {
            useruserChoice = Input.intInput();
            if (useruserChoice == 1) {
                addDevice(list);
                break;
            } else if (useruserChoice == 2) {
                addClearDevice(list);
                break;
            } else if (useruserChoice != 3) {
                System.err.println("Выберите действие из предложенных");
            }
        } while (useruserChoice != 3);
    }

    /**
     * Метод для выбора типа устройства для создания с заполнением полей
     *
     * @param list список с устройствами
     */
    private static void addDevice(ArrayList<Computer> list) {
        Devices deviceChoice = chooseDeviceType();

        if (deviceChoice == null) {
            return; // Прерываем выполнение метода, так как выбрана неизвестная команда
        }
        switch (deviceChoice) {
            case COMPUTER -> list.add(computerMakerInput());
            case PERSONAL_COMPUTER -> list.add(personalComputerMakerInput());
            case LAPTOP -> list.add(laptopMakerInput());
            case TABLET -> list.add(tabletMakerInput());
            case EXIT -> System.out.println("Выход");
        }

    }

    /**
     * Метод для выбора создаваемого устройства без полей
     *
     * @param list список с устройствами
     */
    private static void addClearDevice(ArrayList<Computer> list) {
        Devices deviceChoice = chooseDeviceType();

        if (deviceChoice == null) {
            return; // Прерываем выполнение метода, так как выбрана неизвестная команда
        }
        switch (deviceChoice) {
            case COMPUTER -> list.add(new Computer());
            case LAPTOP -> list.add(new Laptop());
            case PERSONAL_COMPUTER -> list.add(new PersonalComputer());
            case TABLET -> list.add(new Tablet());
            case EXIT -> System.out.println("Выход");
        }
    }

    /**
     * Метод для создания устройства с полями
     *
     * @return экземляр класса Computer
     */
    private static Computer computerMakerInput() {
        String name;
        int releaseYear;
        System.out.println("Название:");
        name = Input.stringInput();
        System.out.println("Год выпуска:");
        releaseYear = inputYear();
        return new Computer(releaseYear, name);
    }

    /**
     * Метод для создания ноутбука с полями
     *
     * @return экземляр класса Laptop
     */
    private static Laptop laptopMakerInput() {
        String model;
        String manufacturer;
        int releaseYear;
        int screenDiagonal;
        System.out.println("Модель:");
        model = Input.stringInput();
        System.out.println("Год выпуска:");
        releaseYear = inputYear();
        System.out.println("Производитель:");
        manufacturer = Input.stringInput();
        System.out.println("Диагональ экрана:");
        do {
            screenDiagonal = Input.intInput();
            if (screenDiagonal <= 0) {
                System.err.println("Диагональ должна быть больше 0");
            }
        } while (screenDiagonal <= 0);
        return new Laptop(releaseYear, model, screenDiagonal, manufacturer);
    }

    /**
     * Метод для создания персонального компьютера с полями
     *
     * @return экземляр класса PersonalComputer
     */
    private static PersonalComputer personalComputerMakerInput() {
        String model;
        String operatingSystem;
        int releaseYear;
        int processorCoresNumber;
        System.out.println("Модель:");
        model = Input.stringInput();
        System.out.println("Год выпуска:");
        releaseYear = inputYear();
        System.out.println("Операционная система:");
        operatingSystem = Input.stringInput();
        System.out.println("Кол-во ядер процессора:");
        processorCoresNumber = Input.naturalIntInput();
        return new PersonalComputer(releaseYear, model, processorCoresNumber, operatingSystem);
    }

    /**
     * Метод для создания планшета с полями
     *
     * @return экземляр класса Tablet
     */
    private static Tablet tabletMakerInput() {
        String model;
        String screenResolution;
        int releaseYear;
        int batteryLife;
        System.out.println("Модель:");
        model = Input.stringInput();
        System.out.println("Год выпуска:");
        releaseYear = inputYear();
        System.out.println("Разрешение экрана:");
        screenResolution = Input.stringInput();
        System.out.println("Время работы от батареи:");
        do {
            batteryLife = Input.intInput();
            if (batteryLife <= 0) {
                System.err.println("Время работы от батареи не может быть отрицательным");
            }
        } while (batteryLife < 0);
        return new Tablet(releaseYear, model, batteryLife, screenResolution);
    }

    /**
     * Метод для вывода всех устройств из списка
     *
     * @param list список с устройствами
     */
    private static void printAllComputers(ArrayList<Computer> list) {
        int count = 1;
        if (list.isEmpty()) {
            System.out.println("Устройств нет");
        } else {
            System.out.println("""
                    УСТРОЙСТВА
                    _____________________
                    """);
            for (Computer computer : list) {
                System.out.printf("№%d %s\n", count++, computer.toString());
            }
            System.out.println("______________________");
        }
    }

    /**
     * Метод для удаления устройства из списка
     *
     * @param list список с устройствами
     */
    private static void deleteComputer(ArrayList<Computer> list) {
        if (list.isEmpty()) {
            System.out.println("Устройств нет");
        } else {
            System.out.println("Введите номер элемента для удаления:");
            try {
                list.remove(Input.naturalIntInput() - 1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Выбран несуществующий элемент");
            }
        }
    }

    /**
     * Метод для сравнения 2-х экземпляров
     *
     * @param list список с устройствами
     */
    private static void compareComputers(ArrayList<Computer> list) {
        int firstComputerNumber, secondComputerNumber;
        if (list.size() < 2) {
            System.out.println("Устройств недостаточно");
        } else {
            System.out.println("Введите номер устройства:");
            firstComputerNumber = Input.naturalIntInput();
            System.out.println("Введите номер устройства для сравнения:");
            secondComputerNumber = Input.naturalIntInput();
            try {
                if (list.get(firstComputerNumber - 1).hashCode() == list.get(secondComputerNumber - 1).hashCode() && list.get(firstComputerNumber - 1).equals(list.get(secondComputerNumber - 1))) {
                    System.out.println("устройства эквивалентны");
                } else {
                    System.out.println("устройства различаются");
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Выбраны несуществующие индексы");
            }
        }
    }

    /**
     * Метод для вывода типов устройств
     */
    private static void typesOutput() {
        System.out.print("""
                ДОБАВЛЕНИЕ
                _______________________________________
                Выберите тип устройства для добавления:
                1 - Вычислительная машина
                2 - Персональный компьютер
                3 - Ноутбук
                4 - Планшет
                5 - Назад
                _______________________________________
                """);
    }

    /**
     * Метод для вывода пунктов меню
     */
    private static void menuOutput() {
        System.out.print("""
                МЕНЮ:
                ______________________________
                Выберите пункт меню:
                1 - Добавить устройство
                2 - Удалить устройство
                3 - Вывод всех устройств
                4 - Сравнение устройств
                5 - Выход
                ______________________________
                """);
    }

    /**
     * Метод для вывода меню создания
     */
    private static void createInfo() {
        System.out.print("""
                СОЗДАНИЕ:
                ___________________________________
                Выберите пункт меню:
                1 - Заполнить данные об устройстве
                2 - Создать устройство без данных
                3 - Назад
                ___________________________________
                """);
    }


    /**
     * Метод для ввода и проверки года выпуска устройства. Пользователь будет приглашен ввести год
     * до тех пор, пока не будет введен корректный год, который должен быть не менее 1804 и не более текущего года.
     *
     * @return Корректный год выпуска устройства.
     */
    private static int inputYear() {
        int year;
        do {
            year = Input.intInput();
            if (year < 1804) {
                System.err.println("Первые перфокарты были изобретены в 1804. Вы уверены?");
            } else if (year > Year.now().getValue()) {
                System.err.println("На дворе " + Year.now().getValue() + ". Вы уверены?");
            }
        } while (year < 1804 || year > Year.now().getValue());
        return year;
    }

    /**
     * Метод для выбора типа устройства пользователем и возвращения выбора в виде перечисления Devices.
     *
     * @return Выбор типа устройства в виде перечисления Devices или null, если выбрана неизвестная команда.
     */
    private static Devices chooseDeviceType() {
        int userChoice;
        typesOutput();
        userChoice = Input.intInput();

        try {
            return Devices.values()[userChoice - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Использована неизвестная команда");
            return null;
        }
    }
}

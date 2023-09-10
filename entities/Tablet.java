package entities;

import java.util.Objects;

/**
 * Класс, представляющий планшет, наследуется от класса Computer.
 */
public class Tablet extends Computer {
    private int batteryLife; // Время работы от аккумулятора (в часах).
    private String screenResolution; // Разрешение экрана планшета.

    /**
     * Конструктор класса, инициализирующий объект Tablet с указанными параметрами.
     *
     * @param releaseYear      Год выпуска планшета.
     * @param model            Модель планшета.
     * @param batteryLife      Время работы от аккумулятора планшета (в часах).
     * @param screenResolution Разрешение экрана планшета.
     */
    public Tablet(int releaseYear, String model, int batteryLife, String screenResolution) {
        super(releaseYear, model); // Вызов конструктора суперкласса для инициализации года выпуска и модели.
        this.batteryLife = batteryLife;
        this.screenResolution = screenResolution;
    }

    /**
     * Конструктор класса, инициализирующий объект Tablet с параметрами по умолчанию.
     */
    public Tablet() {
        super(); // Вызов конструктора суперкласса без параметров.
        this.batteryLife = 0; // Установка времени работы от аккумулятора по умолчанию.
        this.screenResolution = "Неизвестное разрешение"; // Установка разрешения экрана по умолчанию.
    }

    /**
     * Получение времени работы от аккумулятора планшета.
     *
     * @return Время работы от аккумулятора (в часах).
     */
    public int getBatteryLife() {
        return batteryLife;
    }

    /**
     * Установка времени работы от аккумулятора планшета.
     *
     * @param batteryLife Время работы от аккумулятора (в часах).
     */
    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    /**
     * Получение разрешения экрана планшета.
     *
     * @return Разрешение экрана.
     */
    public String getScreenResolution() {
        return screenResolution;
    }

    /**
     * Установка разрешения экрана планшета.
     *
     * @param screenResolution Разрешение экрана.
     */
    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    /**
     * Переопределение метода equals для сравнения двух объектов Tablet.
     *
     * @param o Объект, с которым производится сравнение.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tablet tablet)) return false;
        if (!super.equals(o)) return false; // Вызов суперкласса для сравнения общих полей.

        if (batteryLife != tablet.batteryLife) return false;
        return Objects.equals(screenResolution, tablet.screenResolution);
    }

    /**
     * Переопределение метода hashCode для вычисления хэш-кода объекта Tablet.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + batteryLife;
        result = 31 * result + (screenResolution != null ? screenResolution.hashCode() : 0);
        return result;
    }

    /**
     * Переопределение метода toString для создания текстового представления объекта Tablet.
     *
     * @return Строка с информацией о планшете (год выпуска, модель, время работы от аккумулятора и разрешение экрана).
     */
    @Override
    public String toString() {
        return String.format("""
                Планшет:
                \tГод выпуска: %d
                \tМодель: %s
                \tВремя работы от аккумулятора: %d
                \tРазрешение экрана: %s""", super.getReleaseYear(), super.getModel(), batteryLife, screenResolution);
    }
}
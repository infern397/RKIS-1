package entities;

import java.util.Objects;

/**
 * Класс, представляющий ноутбук, наследуется от класса Computer.
 */
public class Laptop extends Computer {
    private int screenDiagonal; // Диагональ экрана ноутбука.
    private String manufacturer; // Производитель ноутбука.

    /**
     * Конструктор класса, инициализирующий объект Laptop с указанными параметрами.
     *
     * @param releaseYear    Год выпуска ноутбука.
     * @param model          Модель ноутбука.
     * @param screenDiagonal Диагональ экрана ноутбука.
     * @param manufacturer   Производитель ноутбука.
     */
    public Laptop(int releaseYear, String model, int screenDiagonal, String manufacturer) {
        super(releaseYear, model); // Вызов конструктора суперкласса для инициализации года выпуска и модели.
        this.screenDiagonal = screenDiagonal;
        this.manufacturer = manufacturer;
    }

    /**
     * Конструктор класса, инициализирующий объект Laptop с параметрами по умолчанию.
     */
    public Laptop() {
        super(); // Вызов конструктора суперкласса без параметров.
        this.screenDiagonal = 0; // Установка диагонали экрана по умолчанию.
        this.manufacturer = "Неизвестный производитель"; // Установка производителя по умолчанию.
    }

    /**
     * Получение диагонали экрана ноутбука.
     *
     * @return Диагональ экрана ноутбука.
     */
    public int getScreenDiagonal() {
        return screenDiagonal;
    }

    /**
     * Установка диагонали экрана ноутбука.
     *
     * @param screenDiagonal Диагональ экрана ноутбука.
     */
    public void setScreenDiagonal(int screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    /**
     * Получение производителя ноутбука.
     *
     * @return Производитель ноутбука.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Установка производителя ноутбука.
     *
     * @param manufacturer Производитель ноутбука.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Переопределение метода equals для сравнения двух объектов Laptop.
     *
     * @param o Объект, с которым производится сравнение.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop laptop)) return false;
        if (!super.equals(o)) return false; // Вызов суперкласса для сравнения общих полей.

        if (screenDiagonal != laptop.screenDiagonal) return false;
        return Objects.equals(manufacturer, laptop.manufacturer);
    }

    /**
     * Переопределение метода hashCode для вычисления хэш-кода объекта Laptop.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + screenDiagonal;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }

    /**
     * Переопределение метода toString для создания текстового представления объекта Laptop.
     *
     * @return Строка с информацией о ноутбуке (год выпуска, модель, диагональ экрана и производитель).
     */
    @Override
    public String toString() {
        return String.format("""
                Ноутбук:
                \tГод выпуска: %d
                \tМодель: %s
                \tДиагональ экрана: %d
                \tПроизводитель: %s""", super.getReleaseYear(), super.getModel(), screenDiagonal, manufacturer);
    }
}
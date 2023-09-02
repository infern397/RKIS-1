package entities;

import java.util.Objects;

/**
 * Класс, представляющий вычислительную машину.
 */
public class Computer {
    private int releaseYear; // Год выпуска вычислительной машины.
    private String model; // Модель вычислительной машины.

    /**
     * Конструктор класса, инициализирующий объект Computer с указанными годом выпуска и моделью.
     *
     * @param releaseYear Год выпуска компьютера.
     * @param model       Модель компьютера.
     */
    public Computer(int releaseYear, String model) {
        this.releaseYear = releaseYear;
        this.model = model;
    }

    /**
     * Конструктор класса, инициализирующий объект Computer с годом выпуска по умолчанию и неизвестной моделью.
     */
    public Computer() {
        this.releaseYear = 2023; // Установка года выпуска по умолчанию.
        this.model = "Неизвестная модель"; // Установка модели по умолчанию.
    }

    /**
     * Получение года выпуска компьютера.
     *
     * @return Год выпуска компьютера.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Установка года выпуска компьютера.
     *
     * @param releaseYear Год выпуска компьютера.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Получение модели компьютера.
     *
     * @return Модель компьютера.
     */
    public String getModel() {
        return model;
    }

    /**
     * Установка модели компьютера.
     *
     * @param model Модель компьютера.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Переопределение метода equals для сравнения двух объектов Computer.
     *
     * @param o Объект, с которым производится сравнение.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer computer)) return false;

        if (releaseYear != computer.releaseYear) return false;
        return Objects.equals(model, computer.model);
    }

    /**
     * Переопределение метода hashCode для вычисления хэш-кода объекта Computer.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = releaseYear;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    /**
     * Переопределение метода toString для создания текстового представления объекта Computer.
     *
     * @return Строка с информацией о компьютере (год выпуска и модель).
     */
    @Override
    public String toString() {
        return String.format("""
                Вычислительная машина:
                \tГод выпуска: %d
                \tМодель: %s""", releaseYear, model);
    }
}
package entities;

import java.util.Objects;

/**
 * Класс, представляющий персональный компьютер, наследуется от класса Computer.
 */
public class PersonalComputer extends Computer {
    private int processorCoresNumber; // Количество ядер процессора.
    private String operatingSystem; // Операционная система.

    /**
     * Конструктор класса, инициализирующий объект PersonalComputer с указанными параметрами.
     *
     * @param releaseYear          Год выпуска персонального компьютера.
     * @param model                Модель персонального компьютера.
     * @param processorCoresNumber Количество ядер процессора персонального компьютера.
     * @param operatingSystem      Операционная система персонального компьютера.
     */
    public PersonalComputer(int releaseYear, String model, int processorCoresNumber, String operatingSystem) {
        super(releaseYear, model); // Вызов конструктора суперкласса для инициализации года выпуска и модели.
        this.processorCoresNumber = processorCoresNumber;
        this.operatingSystem = operatingSystem;
    }

    /**
     * Конструктор класса, инициализирующий объект PersonalComputer с параметрами по умолчанию.
     */
    public PersonalComputer() {
        super(); // Вызов конструктора суперкласса без параметров.
        this.processorCoresNumber = 0; // Установка количества ядер по умолчанию.
        this.operatingSystem = "Неизвестная операционная система"; // Установка операционной системы по умолчанию.
    }

    /**
     * Получение количества ядер процессора персонального компьютера.
     *
     * @return Количество ядер процессора.
     */
    public int getProcessorCoresNumber() {
        return processorCoresNumber;
    }

    /**
     * Установка количества ядер процессора персонального компьютера.
     *
     * @param processorCoresNumber Количество ядер процессора.
     */
    public void setProcessorCoresNumber(int processorCoresNumber) {
        this.processorCoresNumber = processorCoresNumber;
    }

    /**
     * Получение операционной системы персонального компьютера.
     *
     * @return Операционная система.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * Установка операционной системы персонального компьютера.
     *
     * @param operatingSystem Операционная система.
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Переопределение метода equals для сравнения двух объектов PersonalComputer.
     *
     * @param o Объект, с которым производится сравнение.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalComputer that)) return false;
        if (!super.equals(o)) return false; // Вызов суперкласса для сравнения общих полей.

        if (processorCoresNumber != that.processorCoresNumber) return false;
        return Objects.equals(operatingSystem, that.operatingSystem);
    }

    /**
     * Переопределение метода hashCode для вычисления хэш-кода объекта PersonalComputer.
     *
     * @return Хэш-код объекта.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + processorCoresNumber;
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        return result;
    }

    /**
     * Переопределение метода toString для создания текстового представления объекта PersonalComputer.
     *
     * @return Строка с информацией о персональном компьютере (год выпуска, модель, количество ядер и операционная система).
     */
    @Override
    public String toString() {
        return String.format("""
                Персональный компьютер:
                \tГод выпуска: %d
                \tМодель: %s
                \tКоличество ядер: %d
                \tОперационная система: %s""", super.getReleaseYear(), super.getModel(), processorCoresNumber, operatingSystem);
    }
}
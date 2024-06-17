package conversor;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Conversor {

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            // Crear un JLabel para el mensaje
            JLabel label = new JLabel("Seleccione una opción para convertir:");

            // Crear un JComboBox con las opciones de conversión
            String[] options = {"Conversor de monedas", "Segundos a Horas"};
            JComboBox<String> comboBox = new JComboBox<>(options);

            // Crear un JPanel con GridLayout y añadir el JLabel y JComboBox
            JPanel panel = new JPanel(new GridLayout(2, 1));
            panel.add(label);
            panel.add(comboBox);

            // Mostrar el cuadro de diálogo con JPanel
            int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Menu de Conversión",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                String selectedOption = (String) comboBox.getSelectedItem();
                switch (selectedOption) {
                    case "Conversor de monedas":
                        convertirMonedas();
                        break;
                    case "Segundos a Horas":
                        convertirSegundosAHoras();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                
                // Preguntar al usuario si desea continuar usando el programa
                int option = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea continuar usando el programa?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa Finalizado", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Programa Finalizado", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                continuar = false;
            }
        }
    }

    private static void convertirMonedas() {
        // Solicitar la cantidad a convertir en un bucle hasta que se proporcione un valor válido
        boolean validInput = false;
        double amount = 0;
        while (!validInput) {
            String amountStr = JOptionPane.showInputDialog("Ingrese la cantidad de dinero a convertir:");
            if (amountStr != null && !amountStr.isEmpty()) {
                try {
                    amount = Double.parseDouble(amountStr);
                    validInput = true;  // Salir del bucle si la entrada es válida
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El valor no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Opciones de conversión de monedas
        String[] currencyOptions = {
            "De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen", "De Pesos a Won Coreano",
            "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos"
        };
        String selectedConversion = (String) JOptionPane.showInputDialog(
            null,
            "Selecciona la conversión de moneda:",
            "Conversor de Moneda",
            JOptionPane.QUESTION_MESSAGE,
            null,
            currencyOptions,
            currencyOptions[0]
        );

        if (selectedConversion != null) {
            double resultConversion = 0;
            String conversionResult = "";

            // Definir las tasas de conversión (ejemplos)
            double pesosADolar = 0.054; // Ejemplo: 1 peso = 0.054 dólares
            double pesosAEuro = 0.048;  // Ejemplo: 1 peso = 0.048 euros
            double pesosALibras = 0.041; // Ejemplo: 1 peso = 0.041 libras
            double pesosAYen = 5.90;     // Ejemplo: 1 peso = 5.90 yenes
            double pesosAWonCoreano = 70.12; // Ejemplo: 1 peso = 70.12 wones coreanos
            double dolarAPesos = 18.50;  // Ejemplo: 1 dólar = 18.50 pesos
            double euroAPesos = 20.83;   // Ejemplo: 1 euro = 20.83 pesos
            double librasAPesos = 24.45; // Ejemplo: 1 libra = 24.45 pesos
            double yenAPesos = 0.17;     // Ejemplo: 1 yen = 0.17 pesos
            double wonCoreanoAPesos = 0.014; // Ejemplo: 1 won coreano = 0.014 pesos

            // Realizar la conversión según la opción seleccionada
            switch (selectedConversion) {
                case "De Pesos a Dólar":
                    resultConversion = amount * pesosADolar;
                    conversionResult = "Tienes: " + resultConversion + " Dólares";
                    break;
                case "De Pesos a Euro":
                    resultConversion = amount * pesosAEuro;
                    conversionResult = "Tienes: " + resultConversion + " Euros";
                    break;
                case "De Pesos a Libras":
                    resultConversion = amount * pesosALibras;
                    conversionResult = "Tienes: " + resultConversion + " Libras";
                    break;
                case "De Pesos a Yen":
                    resultConversion = amount * pesosAYen;
                    conversionResult = "Tienes: " + resultConversion + " Yenes";
                    break;
                case "De Pesos a Won Coreano":
                    resultConversion = amount * pesosAWonCoreano;
                    conversionResult = "Tienes: " + resultConversion + " Wones Coreanos";
                    break;
                case "De Dólar a Pesos":
                    resultConversion = amount * dolarAPesos;
                    conversionResult = "Tienes: " + resultConversion + " Pesos";
                    break;
                case "De Euro a Pesos":
                    resultConversion = amount * euroAPesos;
                    conversionResult = "Tienes: " + resultConversion + " Pesos";
                    break;
                case "De Libras a Pesos":
                    resultConversion = amount * librasAPesos;
                    conversionResult = "Tienes: " + resultConversion + " Pesos";
                    break;
                case "De Yen a Pesos":
                    resultConversion = amount * yenAPesos;
                    conversionResult = "Tienes: " + resultConversion + " Pesos";
                    break;
                case "De Won Coreano a Pesos":
                    resultConversion = amount * wonCoreanoAPesos;
                    conversionResult = "Tienes: " + resultConversion + " Pesos";
                    break;
                default:
                    conversionResult = "Conversión no válida";
                    break;
            }

            // Mostrar el resultado de la conversión
            JOptionPane.showMessageDialog(null, conversionResult, "Resultado de la Conversión", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void convertirSegundosAHoras() {
        // Solicitar los segundos a convertir
        String segundosStr = JOptionPane.showInputDialog("Ingrese la cantidad de segundos a convertir a horas:");
        if (segundosStr != null && !segundosStr.isEmpty()) {
            try {
                int segundos = Integer.parseInt(segundosStr);
                int horas = segundos / 3600; // Obtener las horas enteras
                int minutosRestantes = (segundos % 3600) / 60; // Obtener los minutos restantes

                String conversionResult;
                if (horas > 0) {
                    conversionResult = horas + " horas";
                    if (minutosRestantes > 0) {
                        conversionResult += " y " + minutosRestantes + " minutos";
                    }
                } else {
                    conversionResult = minutosRestantes + " minutos";
                }

                JOptionPane.showMessageDialog(null, segundos + " segundos equivalen a " + conversionResult, "Resultado de la Conversión", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El valor no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


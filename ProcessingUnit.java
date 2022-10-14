import java.util.Scanner;

public class ProcessingUnit {
    Scanner scanner = new Scanner(System.in);
    String ACC;

    void aVoid(String OR, String AR, ControlUnit controlUnit, Storage storage) {
        // Operation Register == BRU
        if ("BRU".equals(OR)) {
            controlUnit.IC = AR;
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == RWD
        else if ("RWD".equals(OR)) {
            System.out.print("Number: ");
            storage.data[Integer.parseInt(AR)] = new_data(scanner.nextInt());
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == LDA
        else if ("LDA".equals(OR)) {
            ACC = storage.data[Integer.parseInt(AR)];
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == STO
        else if ("STO".equals(OR)) {
            storage.data[Integer.parseInt(AR)] = ACC;
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == SUB
        else if ("SUB".equals(OR)) {
            ACC = new_data(Integer.parseInt(ACC) - Integer.parseInt(storage.data[Integer.parseInt(AR)]));
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == BRM
        else if ("BRM".equals(OR)) {
            if (Integer.parseInt(ACC) < 0) {
                controlUnit.IC = AR;
            }
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == MPY
        else if ("MPY".equals(OR)) {
            ACC = new_data(Integer.parseInt(ACC) * Integer.parseInt(storage.data[Integer.parseInt(AR)]));
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == DIV
        else if ("DIV".equals(OR)) {
            ACC = new_data(Integer.parseInt(ACC) / Integer.parseInt(storage.data[Integer.parseInt(AR)]));
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == ADD
        else if ("ADD".equals(OR)) {
            ACC = new_data(Integer.parseInt(ACC) + Integer.parseInt(storage.data[Integer.parseInt(AR)]));
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == WWD
        else if ("WWD".equals(OR)) {
            System.out.println("Answer: " + Integer.parseInt(storage.data[Integer.parseInt(AR)]));
            controlUnit.aVoid(storage, controlUnit);
        }

        // Operation Register == HLT
        else if ("HLT".equals(OR)) {
            System.exit(0);
        }

    }


    private String new_data(int Int) {
        StringBuilder data = new StringBuilder();
        if (Int < 0) {
            data.append("-");
            Int *= -1;
        } else {
            data.append("+");
        }
        String new_data = Integer.toString(Int);
        data.append("0".repeat(Math.max(0, 10 - new_data.length())));
        data.append(new_data);
        return data.toString();
    }
}

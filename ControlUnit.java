public class ControlUnit {

    String IC = "0000", OR, AR;
    ProcessingUnit processingUnit = new ProcessingUnit();
    String code_line;

    void aVoid(Storage storage, ControlUnit controlUnit) {

        code_line = storage.data[Integer.parseInt(IC)];

        new_ic(Integer.parseInt(IC) + 1);

        OR = code_line.substring(1, 4);
        AR = code_line.substring(7, 11);

        processingUnit.aVoid(OR, AR, controlUnit, storage);

    }


    private void new_ic(int new_ic_int) {
        String new_ic = Integer.toString(new_ic_int);
        IC = "";
        for (int i = 0; i < 4 - new_ic.length(); i++) {
            IC += "0";
        }
        IC += new_ic;
    }
}

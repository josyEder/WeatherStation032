public class FloodPool {

    //Temperaturemeasuremnets
    private static double _outsideTemperature;
    private static double _containerTemperature;
    private static double _waterTermperature;
    //  private static double _flowrateTemperature;  --> Sensor für Messung fehlt

    //other measurements
    private static double _waterlevel;
    //private static double _flowrate ;   --> haben noch keinen Sensor für die Messung
    private static double _gas;

    public FloodPool(Double outsideTemp, double waterTemp, double containerTemp, double waterLev, double gas) {
        this._outsideTemperature = outsideTemp;
        this._containerTemperature = containerTemp;
        this._waterTermperature = waterTemp;
        this._waterlevel = waterLev;
        this._gas = gas;
    }

    public FloodPool() {
    }

    public static double getOutsideTemperature() {
        return _outsideTemperature;
    }

    public static double getContainerTemperature() {
        return _containerTemperature;
    }

    public static double getWaterTermperature() {
        return _waterTermperature;
    }

    public static double getWaterlevel() {
        return _waterlevel;
    }

    public static double getGas() {
        return _gas;
    }

    public static void setOutsideTemperature(double outsideTemperature) {
        FloodPool._outsideTemperature = outsideTemperature;
    }

    public static void setContainerTemperature(double containerTemperature) {
        FloodPool._containerTemperature = containerTemperature;
    }

    public static void setWaterTermperature(double waterTermperature) {
        FloodPool._waterTermperature = waterTermperature;
    }

    public static void setWaterlevel(double waterlevel) {
        FloodPool._waterlevel = waterlevel;
    }

    public static void setGas(double gas) {
        FloodPool._gas = gas;
    }


}

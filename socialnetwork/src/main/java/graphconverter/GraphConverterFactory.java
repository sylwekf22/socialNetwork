package graphconverter;

// Klasa fabryka do tworzenia konwerterów
public class GraphConverterFactory {
    public GraphConverterFactory() { }

    public GraphConverter getConverter(Class<? extends GraphConverter> graphConverterClass) {
        if (graphConverterClass.isInstance(LittleGraphConverter.class)) {
            return new LittleGraphConverter();
        } else if (graphConverterClass.isInstance(MediumGraphConverter.class)) {
            return new MediumGraphConverter();
        }else if (graphConverterClass.isInstance(BigGraphConverter.class)){
            return new BigGraphConverter();
        }else{
            return new FiveYearPeriodGraphConverter("", "");
        }
    }
}
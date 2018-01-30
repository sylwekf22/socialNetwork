package graph;

public class GraphConverterFactory {
    public GraphConverterFactory() {

    }

    public GraphConverter getConverter(Class<? extends GraphConverter> graphConverterClass) {
        if (graphConverterClass.isInstance(LittleGraphConverter.class)) {
            return new LittleGraphConverter();
        } else if (graphConverterClass.isInstance(MediumGraphConverter.class)) {
            return new MediumGraphConverter();
        }else {
            return new BigGraphConverter();
        }
    }
}
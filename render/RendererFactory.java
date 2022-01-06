package render;
public class RendererFactory{
    public Renderer build(String input){
        Renderer render = null;
        switch(input){
            case "ConsoleRenderer", "consolerenderer", "console":
                render = new ConsoleRenderer();
                break;
            case "void", "void renderer", "none":
                render = new voidRenderer();
                break;
            default:
                System.err.println("The requested Render not found in the system!.\nThe system choose the default(console).");
                render = new ConsoleRenderer();
        }
        return render;
    }    
}

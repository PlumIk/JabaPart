import java.io.File;
import java.io.IOException;

import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class main {

    public static void main(String[] args){


        File f=new File("/home/alex/Prog/Jaba/NewJNIone/FoeShow/yourTestProgram.bc");
        if(f.exists()) {

            Source s = null;
            Source.Builder b = Source.newBuilder("llvm", f);
            try {
                s = b.build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Context c = Context.newBuilder().allowNativeAccess(true).build();
            Value lib = c.eval(s);
            Value fn = lib.getMember("printHello");
            fn.executeVoid();

        }
        else {
            System.out.println("File not exist");
        }
    }


}

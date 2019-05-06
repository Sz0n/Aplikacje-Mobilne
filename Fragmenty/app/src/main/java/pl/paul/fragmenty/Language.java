package pl.paul.fragmenty;

public class Language {
    int image;
    String name;
    private String description;
    public static final Language[] languages = {
            new Language("Python", R.drawable.python,"Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991, Python's design philosophy emphasizes code readability with its notable use of significant whitespace. Its language constructs and object-oriented approach aims to help programmers write clear, logical code for small and large-scale projects.[26] Van Rossum shouldered sole responsibility for the project until July 2018 but now shares his leadership as a member of a five-person steering council.[27][28][29]\n" +
                    "\n" +
                    "Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including procedural, object-oriented, and functional programming. Python is often described as a \"batteries included\" language due to its comprehensive standard library.[30]\n" +
                    "\n" +
                    "Python interpreters are available for many operating systems. A global community of programmers develops and maintains CPython, an open source[31] reference implementation. A non-profit organization, the Python Software Foundation, manages Python and CPython."),
            new Language("Java", R.drawable.java,"Java is a general-purpose programming language that is class-based, object-oriented,[15] and designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA),[16] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[17] Java applications are typically compiled to \"bytecode\" that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. The syntax of Java is similar to C and C++, but it has fewer low-level facilities than either of them. As of 2018, Java was one of the most popular programming languages in use according to GitHub,[18] [19] particularly for client-server web applications, with a reported 9 million developers.[20]\n" +
                    "\n" +
                    "Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle) and released in 1995 as a core component of Sun Microsystems' Java platform. The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun had relicensed most of its Java technologies under the GNU General Public License. Meanwhile, others have developed alternative implementations of these Sun technologies, such as the GNU Compiler for Java (bytecode compiler), GNU Classpath (standard libraries), and IcedTea-Web (browser plugin for applets).\n" +
                    "\n" +
                    "The latest version is Java SE 12, released in March 2019. Since Java 9 is no longer supported, Oracle advises its users to \"immediately transition\" to Java 12. Oracle released the last public update for the legacy Java 8 LTS, which is free for commercial use, in January 2019. Java 8 will be supported with public updates for personal use up to at least December 2020. Oracle and others \"highly recommend that you uninstall older versions of Java\"[21] because of serious risks due to unresolved security issues.[21] Oracle extended support for Java 6 ended in December 2018.[22]")
    };
    private Language(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public int getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return this.name;
    }
}

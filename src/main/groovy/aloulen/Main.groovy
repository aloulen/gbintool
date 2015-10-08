package aloulen
import groovy.util.CliBuilder

class Main {
    static void main(def args) {
        def cli = new CliBuilder(usage:'systemFile')
cli.with {
 h longOpt:'help', 'permet d\'ajouter ou afficher un text dans un fichier'
 fc longOpt:'fileContent',argName:'path', args:2, type:String.class, required: false,valueSeparator: ',' as char, 'syntaxe: -fc fileName,text'
 s longOpt:'show',argName:'path', args:1, type:String.class, required: false, 'Afficher le contenu d\'un fichier'
}
        def op = cli.parse(args)
        if (op.h)
                cli.usage()
        if(op.fc)
{
                
File file = new File(op.fcs[0])
      file.write "${op.fcs[1]}"
      println "Fichier créé et rempli avec succés !"
}
   
if(op.s)
{
    
    File file = new File(op.s)
    if(file.exists() && !file.isDirectory()) { 
    println file.text
}
else
{
   println "fichier n'existe pas"
}

}
}
}

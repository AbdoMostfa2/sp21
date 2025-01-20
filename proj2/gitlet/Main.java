package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Abdelarahman Mostafa
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        // TODO: handle errors that related to args size
        // ToDo: you must not store files at commit you must just store the name of the blobs and
        //     get them from blob file
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                //initializing gitlet repo
                Repository.init();
                break;
            case "add":
                //add file
                Repository.add(args[1]);
                break;
            case "commit":
                Repository.commit(args[1]);
                break;
            case "rm":
                if(args.length == 2){
                    //remove file
                    Repository.rm(args[1]);
                }
                else {
                    //remove branch
                    Repository.rmBranch(args[3]);
                }
                break;
            case "log":
                Repository.log();
                break;
            case "global-log":
                Repository.global_log();
                break;
            case "find":
                Repository.find(args[1]);
                break;
            case "status":
                Repository.status();
                break;
            case "checkout":
                if(args[1].equals("--")){
                    // checkout file in the current commit
                    Repository.checkout(args[2]);
                }else if(args.length>2){
                    //checkout  file in specific commit
                    Repository.checkout(args[1],args[3]);
                }else {
                    //checkout branch
                    Repository.checkoutBranch(args[1]);
                }
                break;
            case "branch":
                Repository.branch(args[1]);
                break;




        }
    }
}

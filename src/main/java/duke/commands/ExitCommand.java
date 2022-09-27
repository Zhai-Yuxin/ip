package duke.commands;

import duke.Storage;
import duke.TaskList;

public class ExitCommand extends Command {

    private final String EXIT_MESSAGE = "\tThank you for choosing duke. Hope to see you again soon!!!";

    public ExitCommand(String commandWord) {
        super(commandWord);
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {

    }

    @Override
    public boolean checkExit() {
        System.out.println(EXIT_MESSAGE);
        return true;
    }
}

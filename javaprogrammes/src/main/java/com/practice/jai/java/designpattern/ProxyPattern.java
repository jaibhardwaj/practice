package com.practice.jai.java.designpattern;

interface Command
{
    void runCommand(String command) throws Exception;
}

class WindowsCommand implements Command
{
    @Override
    public void runCommand(String command) throws Exception
    {
        Runtime.getRuntime().exec(command);
    }
}

class AdminCommandImpl implements Command
{
    private boolean isAdmin;
    private WindowsCommand windowsCommand;
    public AdminCommandImpl(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
        windowsCommand = new WindowsCommand();
    }

    @Override
    public void runCommand(String command) throws Exception
    {
        if(isAdmin)
        {
            windowsCommand.runCommand(command);
        }
        else
        {
            if (command.trim().startsWith("rm"))
            {
                throw new Exception("rm command is not allowed for non admin users.");
            } else
            {
                windowsCommand.runCommand(command);
            }
        }
    }
}

public class ProxyPattern
{
}

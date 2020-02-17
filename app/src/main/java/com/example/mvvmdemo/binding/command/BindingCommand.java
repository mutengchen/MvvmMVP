package com.example.mvvmdemo.binding.command;

/**
 * Date: 2020/2/17
 * Time: 17:18
 * author: cmt
 * desc:
 */
public class BindingCommand<T> {
    private BindingAction execute;
    public BindingCommand(BindingAction execute){
        this.execute = execute;
    }

    public void execute(){
        if(execute!=null)
            execute.call();
    }
}

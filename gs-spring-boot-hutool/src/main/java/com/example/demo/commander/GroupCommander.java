package com.example.demo.commander;

import java.util.List;
import java.util.Stack;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class GroupCommander implements Commander {
    List<Commander> cmds;
    Stack<List<Commander>> stacks=new Stack<>();
    public GroupCommander(List<Commander> objects) {
        cmds=objects;
    }

    @Override
    public void execute() {
        if(null!=cmds&&cmds.size()>0) {
            cmds.forEach(cmd->{
                cmd.execute();
            });
            stacks.push(cmds);
        }
    }

    @Override
    public void undo() {
        stacks.pop().stream().forEach(cmd->{
            cmd.undo();
        });
    }
}

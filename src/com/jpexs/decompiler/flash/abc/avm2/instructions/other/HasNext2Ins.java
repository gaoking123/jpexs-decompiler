/*
 *  Copyright (C) 2010-2014 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.decompiler.flash.abc.avm2.instructions.other;

import com.jpexs.decompiler.flash.abc.ABC;
import com.jpexs.decompiler.flash.abc.avm2.AVM2Code;
import com.jpexs.decompiler.flash.abc.avm2.ConstantPool;
import com.jpexs.decompiler.flash.abc.avm2.instructions.AVM2Instruction;
import com.jpexs.decompiler.flash.abc.avm2.instructions.InstructionDefinition;
import com.jpexs.decompiler.flash.abc.avm2.model.HasNextAVM2Item;
import com.jpexs.decompiler.flash.abc.avm2.model.LocalRegAVM2Item;
import com.jpexs.decompiler.flash.abc.types.MethodBody;
import com.jpexs.decompiler.flash.abc.types.MethodInfo;
import com.jpexs.decompiler.graph.GraphTargetItem;
import com.jpexs.decompiler.graph.ScopeStack;
import com.jpexs.decompiler.graph.TranslateStack;
import java.util.HashMap;
import java.util.List;

public class HasNext2Ins extends InstructionDefinition {

    public HasNext2Ins() {
        super(0x32, "hasnext2", new int[]{AVM2Code.DAT_LOCAL_REG_INDEX, AVM2Code.DAT_LOCAL_REG_INDEX});
    }

    @Override
    public void translate(boolean isStatic, int scriptIndex, int classIndex, HashMap<Integer, GraphTargetItem> localRegs, TranslateStack stack, ScopeStack scopeStack, ConstantPool constants, AVM2Instruction ins, List<MethodInfo> method_info, List<GraphTargetItem> output, MethodBody body, ABC abc, HashMap<Integer, String> localRegNames, List<String> fullyQualifiedNames, String path, HashMap<Integer, Integer> localRegsAssignmentIps, int ip, HashMap<Integer, List<Integer>> refs, AVM2Code code) {
        int objectReg = ins.operands[0];
        int indexReg = ins.operands[1];
        //stack.push("_loc_" + objectReg + ".hasNext(cnt=_loc_" + indexReg + ")");
        stack.push(new HasNextAVM2Item(ins, new LocalRegAVM2Item(ins, indexReg, localRegs.get(indexReg)), localRegs.get(objectReg)));
    }

    @Override
    public int getStackDelta(AVM2Instruction ins, ABC abc) {
        return 1;
    }

}

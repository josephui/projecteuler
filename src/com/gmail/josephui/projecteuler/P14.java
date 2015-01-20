/*
 * The MIT License
 *
 * Copyright 2015 Joseph Hui <josephui@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.gmail.josephui.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author Joseph Hui <josephui@gmail.com>
 */
public class P14 implements Solver{
    HashMap<Long, Integer> table;
    
    @Override
    public String solve(){
        table = new HashMap(99999999);
        
        int longest = 0;
        int longestIndex = 0;
        for(int i = 1; i <= 999999; i++){
            int curr = numStepsInCollatzSeq(i);
            if(curr > longest){
                longest = curr;
                longestIndex = i;
            }
            if(i %1000 == 0){
                System.out.println(i);
            }
        }
        return longestIndex + "";
    }
    
    int numStepsInCollatzSeq(long n){
        int steps = 0;
        long curr = n;
        
        while(curr != 1){
            curr = (curr%2 == 0) ? curr/2 : 3*curr + 1;
            steps++;
            
            if(table.get(curr) != null){
                table.put(n, table.get(curr) + steps);
                return table.get(n);
            }
        }
        
        table.put(n, steps);
        
        return table.get(n);
    }
}

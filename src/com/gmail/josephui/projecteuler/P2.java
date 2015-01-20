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

/**
 *
 * @author Joseph Hui <josephui@gmail.com>
 */
public class P2 implements Solver{
    static int[] fib;
    
    static{
        fib = new int[50];
        fib[0] = 1;
        fib[1] = 2;
    }
    
    static int fib(int i){
        if(fib[i] != 0){
            return fib[i];
        }
        return fib[i] = fib(i-1) + fib(i-2);
    }
    
    @Override
    public String solve(){
        int total = 0;
        
        for(int i = 0; fib(i) < 4000000; i++){
            if((fib(i) % 2) == 0){
                total += fib(i);
            }
        }
        
        return "" + total;
    }
}

/*
Variable types
let,
const,
var

*/

//Let variable has block scope

var names="krishna";
console.log(names);

if(5>2)
{
    let message="code with krishna";
    console.log("5 is greater than 2");
    console.log(message);
}
//If we use the let varaible outside the block then it will give you error
// console.log(message)

//same variable name: no any error but in let variable it will give you error
var x=10;
var x=20;

console.log(x);
//assining value without creating variable
a=500,b=40
console.log(a);
var a;
var b;


//Var variable has globally or functional scope: we can use it anywhere 
//const variable: if the value is assing then we cannot change it

const social="facebook.com";
console.log(social);
social="programmingwithkrishna";
console.log(social);

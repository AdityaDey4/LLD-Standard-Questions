const orders = [
    {qty : 1, price : 5000},
    {qty : 2, price : 2000},
    {qty : 3, price : 500},
    {qty : 4, price : 1000},
];

const totalAmount = orders.map(order=> order.qty*order.price)
    .filter(price=> price > 1999)
    .reduce((prevSum, currPrice)=> prevSum+currPrice, 0);

console.log(totalAmount);

const first = orders.map(order=> order.qty*order.price);
console.log("Map : "+first);

const second = first.filter(price=> price > 1999);
console.log("Filter : "+second);

const third = second.reduce((prevSum, currPrice)=> prevSum+currPrice, 0);
console.log("Reduce : "+third);


const obj = {
    a : 1,
    b : 2,
    sum() {
        return this.a+this.b;
    }
}

console.log(obj.sum());
const res = obj.sum;
console.log(res());

const res2 = obj.sum.bind(obj);
console.log(res2())

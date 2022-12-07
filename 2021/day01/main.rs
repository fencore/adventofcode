use std::fs::File;
use std::io::prelude::*;

fn main() {
    let mut file = File::open("input.txt")
        .expect("cannot open file");
    let mut data = String::new();
    
    file.read_to_string(&mut data)
        .expect("Error while reading file");

    let depths: Vec<i32> = data.lines()
        .map(|s| s.parse::<i32>().unwrap())
        .collect();

    let mut j = 0;
    depths.windows(2)
        .for_each(|i| if i[1] > i[0] {j+=1});

    let mut k = 0;
    depths.windows(4)
        .for_each(|i| if i[1..4].iter().sum::<i32>() > i[0..3].iter().sum::<i32>() {k+=1});

    print!("Part 1: {}\nPart 2: {}", j, k);
}
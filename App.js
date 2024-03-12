let boxes = document.querySelectorAll(".box");
let resetbtn = document.querySelector("#btn-reset");
let newbtn = document.querySelector("#new-btn");
let msgContainer = document.querySelector(".msg-container");
let Message = document.querySelector("#msg");

let trun0 = true; //x player y player

const winPattren = [
    [0,1,2],
    [0,3,6],
    [0,4,8],
    [1,4,7],
    [2,5,8],
    [2,4,6],
    [3,4,5],
    [6,7,8],
];

const Resetgame = () => {
    trun0 = true;
    boxEnabled();
    msgContainer.classList.add("hide");
}


boxes.forEach((box) => {
    box.addEventListener("click", () => {
        
        if(trun0) {
            box.innerText = "O";
            trun0 = false;
        } else {
            box.innerText = "Y"
            trun0 = true;
        }
        box.disabled = true;
        checkWinner();
    });
});

const ShowWinner = (winner) => {
    Message.innerText = 'Congratulation , Winner is ${winner}';
    msgContainer.classList.remove("hide");   
    boxdisbled();
};


const boxdisbled = () => {
    for(let box of boxes) {
        box.disabled = true;
    }
}

const boxEnabled = () => {
    for(let box of boxes) {
        box.disabled = false;
        box.innerText = "";
    }
}

const checkWinner = () => {
    for(pattern of winPattren)  {
    
            let postVal1 = boxes[pattern[0]].innerText;
            let postVal2 = boxes[pattern[1]].innerText;
            let postVal3 = boxes[pattern[2]].innerText;

            if(postVal1 != "" && postVal2 != "" && postVal3 != "") {
                if(postVal1 == postVal2 && postVal2 == postVal3) {
                    
                    ShowWinner(postVal1);
                }
            }

    }
}

newbtn.addEventListener("click",Resetgame);
resetbtn.addEventListener("click",Resetgame);
//콜백함수 
function checkMood(mood,good,bad){
    if(mood === "good"){
        //기분 좋을 때 동작
        good();
    } else{
        //기분이 안좋을 때
        bad();
    }
}

function cry(){
    console.log("Action :: CRY");
}

function sing(){
    console.log("Action :: Sing");
}

function dance(){
    console.log("ACtion :: DANCE");
}

checkMood("good",cry,sing);
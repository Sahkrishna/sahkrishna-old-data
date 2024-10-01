function addExperience(){
    // console.log("adding experience");

    let nodeElement=document.createElement("textarea");
    nodeElement.classList.add("form-control");
    nodeElement.classList.add("we");
    nodeElement.classList.add("mt-2");
    nodeElement.setAttribute("id","experience");
    nodeElement.setAttribute("rows",3);

    console.log(nodeElement);


    let weButton=document.getElementById("weButton");
   let workExperience= document.getElementById("workExp");

//    //console part for practice
//    console.log(workExperience);

//    for(let wk of workExperience.children){
//     console.log(wk);
//    }



workExperience.insertBefore(nodeElement,weButton);
}

function addQualification(){
    let newNode=document.createElement("textarea");
    newNode.classList.add("form-control");
    newNode.classList.add("mt-2");
    newNode.classList.add("aq");
    newNode.setAttribute("rows",3);


    let qObj=document.getElementById("qualification");
    let qButton=document.getElementById("qButton");

    qObj.insertBefore(newNode,qButton);


    
}



    //right side  part
   
    function generateCv(){
        // console.log("Cv generated");

        let nameField=document.getElementById("name").value;
        // console.log(nameField);

        //setting the name field
        let nameT=document.getElementById("nameT");
        nameT.innerHTML=nameField;
        let nameT2=document.getElementById("nameT2");
        nameT2.innerHTML=nameField;

        //setting the phone number
        let contactField=document.getElementById("contact").value;
        let phoneT=document.getElementById("contactT");
        phoneT.innerHTML=contactField;

        //setting the address
        let addressField=document.getElementById("address").value;
        let addressT=document.getElementById("addressT");
        addressT.innerHTML=addressField;

        //setting the image

        let file=document.getElementById("imgFile").files[0];
        console.log(file);

        let reader=new FileReader();

        reader.readAsDataURL(file);

        // console.log(reader.result);

        reader.onloadend=function(){
           document.getElementById("img").src=reader.result;
           
        }
        

        //setting the link
        let fbField=document.getElementById("facebook").value;
        let fbT=document.getElementById("fbT");
        fbT.innerHTML=fbField;

        let instaField=document.getElementById("instagram").value;
        let instaT=document.getElementById("instaT");
        instaT.innerHTML=instaField;

        let linkedField=document.getElementById("linked").value;
        let linkT=document.getElementById("linkedT");
        // linkT.innerHTML=linkedField;
        console.log(linkedField);
        linkT.innerHTML=linkedField;

        //setting the objective text
        let objectiveField=document.getElementById("objective").value;
        let objectiveT=document.getElementById("objectiveT");
        objectiveT.innerHTML=objectiveField;

        // console.log(objectiveField);


        //setting the work experience
        let expereienceField=document.getElementsByClassName("we");
        // console.log(expereienceField);

        // console.log(expereienceField.length);

        let str="";

        for(let ex of expereienceField){
            str=str+`<li>${ex.value}</li> <br>`;
        }
        document.getElementById("experienceT").innerHTML=str;


        // //setting Academic qualification into the resume

        let AcaQual=document.getElementsByClassName("aq");
        // console.log(AcaQual);

        let strQ="";

        for(let aq of AcaQual){
            strQ=strQ+`<li>${aq.value}</li> <br>`;
        }
        document.getElementById("qualificationT").innerHTML=strQ;



        document.getElementById("cv-form").style.display="none";
        document.getElementById("cv-template").style.display="block";

    } 

    function printResume(){
        window.print();
    }
    

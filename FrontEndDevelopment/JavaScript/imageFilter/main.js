const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

let img = new Image();
let fileName = '';

const downloadBtn = document.getElementById('download-btn');
const uploadFile = document.getElementById('upload-file');
const revertBtn = document.getElementById('revert-btn');

// Add Filters & Effects
document.addEventListener('click',(e )=>{
    if(e.target.classList.contains('filter-btn')){
        // Brightness
        if(e.target.classList.contains('brightness-add')){
            Caman('#canvas', img, function(){
                this.brightness(5).render();
            });
        } else if (e.target.classList.contains('brightness-remove')){
            Caman('#canvas', img, function(){ 
                this.brightness(-5).render();
            });
        } 
        // Contrast
        else if(e.target.classList.contains('contrast-add')){
            Caman('#canvas', img, function(){
                this.contrast(5).render();
            });
        } else if (e.target.classList.contains('contrast-remove')){
            Caman('#canvas', img, function(){ 
                this.contrast(-5).render();
            });
        }
        // Saturation
        else if(e.target.classList.contains('saturation-add')){
            Caman('#canvas', img, function(){
                this.saturation(5).render();
            });
        } else if (e.target.classList.contains('saturation-remove')){
            Caman('#canvas', img, function(){ 
                this.saturation(-5).render();
            });
        }
        // Vibrance
        else if(e.target.classList.contains('vibrance-add')){
            Caman('#canvas', img, function(){
                this.vibrance(5).render();
            });
        } else if (e.target.classList.contains('vibrance-remove')){
            Caman('#canvas', img, function(){ 
                this.vibrance(-5).render();
            });
        }
        // Add Vintage Effect
        else if (e.target.classList.contains('vintage-add')){
            Caman('#canvas', img, function(){ 
                this.vintage().render();
            });
        }
        // Add Lomo Effect
        else if (e.target.classList.contains('lomo-add')){
            Caman('#canvas', img, function(){ 
                this.lomo().render();
            });
        }
        // Add Clarity Effect
        else if (e.target.classList.contains('clarity-add')){
            Caman('#canvas', img, function(){ 
                this.clarity().render();
            });
        }
        // Add Sin City Effect
        else if (e.target.classList.contains('sincity-add')){
            Caman('#canvas', img, function(){ 
                this.sinCity().render();
            });
        }
        // Add Cross Process Effect
        else if (e.target.classList.contains('crossprocess-add')){
            Caman('#canvas', img, function(){ 
                this.crossProcess().render();
            });
        }
        // Add Pinhole Effect
        else if (e.target.classList.contains('pinhole-add')){
            Caman('#canvas', img, function(){ 
                this.pinhole().render();
            });
        }
        // Add Nostalgia Effect
        else if (e.target.classList.contains('nostalgia-add')){
            Caman('#canvas', img, function(){ 
                this.nostalgia().render();
            });
        }
        // Add Her Majesty Effect
        else if (e.target.classList.contains('hermajesty-add')){
            Caman('#canvas', img, function(){ 
                this.herMajesty().render();
            });
        }
    }
});

// Remove Filters
 revertBtn.addEventListener('click', e=>{
    Caman('#canvas', img, function(){
        this.revert();
    });
});

// Upload File
uploadFile.addEventListener('change', e=>{
    //Get File
    const file = document.getElementById('upload-file').files[0];

    // Init FileReader
    const reader = new FileReader();
    if(file){
        fileName = file.name;
        // Read Data as URL
        reader.readAsDataURL(file);
    }

    // Add Image to Canvas
    reader.addEventListener('load', ()=>{
        // Create img
        img = new Image();
        // Set src
        img.src = reader.result;
        // On Image Load, Add to Canvas
        img.onload = function(){
            canvas.width = img.width;
            canvas.height = img.height;
            ctx.drawImage(img, 0, 0, img.width, img.height);
            canvas.removeAttribute('data-cama-id');
        }
    }, false);
});

// Download Event
downloadBtn.addEventListener('click',(e)=>{
    // Get File Extension
    const fileExtension = fileName.slice(-4);
    //const fileExtension = fileName.split('.').pop();
    //const fileExtension = fileName.substring(fileName.lastIndexOf('.')+1, fileName.length) || fileName

    // Init New File Extention
    let newFileName;

    // Check Image Type
    if (fileExtension === '.jpg' || fileExtension === '.jpeg' || fileExtension === '.png'){
    newFileName = fileName.substring(0, fileName.length - 4)+'-edited.jpg';
    }

    // Call Download
    download(canvas, newFileName);
});

// Download Function
function download(canvas, filename){
    // Init event
    let e;
    // Create Link
    const link = document.createElement('a');

    // Set Props
    link.href = canvas.toDataURL('image/jpeg', 0.8);
    link.download = fileName;

    // New Mouse Event
    e = new MouseEvent('click');
    // Dispatch Event
    link.dispatchEvent(e);
}
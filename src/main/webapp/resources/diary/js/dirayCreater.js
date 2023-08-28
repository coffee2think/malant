/**
 * 
 */
function _(id) {
    return document.getElementById(id);
}

function getRs() {
    let txtElement = _('txt');
    if (!txtElement) {
        console.error("Element with id 'txt' not found.");
        return;
    }
    
    let txt = txtElement.value;
    const d = new Date();

    let rsElement = _('rs');
    if (rsElement) {
        rsElement.innerHTML += `<div class="card"><p>${txt}</p><small>${d.toLocaleTimeString()}, ${d.toLocaleDateString()}</small></div>`;
    } else {
        console.error("Element with id 'rs' not found.");
    }
}

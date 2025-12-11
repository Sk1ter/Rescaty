// LLENAR EL MODAL AUTOMATICAMENTE CON LOS ELEMENTOS

document.addEventListener("DOMContentLoaded", () => {

    document.querySelectorAll(".btn-vermas").forEach(btn => {

        btn.addEventListener("click", () => {
            const card = btn.closest(".event-card");

            // Asignar valores al modal
            document.getElementById("modalEventTitulo").innerText =
                card.querySelector("h6").innerText;

            document.getElementById("modalEventOrganizador").innerText =
                card.querySelector("a").innerText;

            document.getElementById("modalEventFecha").innerText =
                card.querySelectorAll(".event-info span")[0].innerText;

            document.getElementById("modalEventHora").innerText =
                card.querySelectorAll(".event-info span")[1].innerText;

            document.getElementById("modalEventUbicacion").innerText =
                card.querySelectorAll(".event-info span")[2].innerText;

            document.getElementById("modalEventCupos").innerText =
                card.querySelector(".event-participantes span").innerText;

            // Imagen
            document.getElementById("modalEventImg").src =
                card.querySelector("img").src;
        });
    });

});


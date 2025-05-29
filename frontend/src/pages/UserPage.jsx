import { RiArrowLeftLine } from "react-icons/ri";
import { FaUserCircle } from "react-icons/fa";
import { Link } from "react-router-dom";
import { userInfo } from "../mocks/mocks";
import TextField from '@mui/material/TextField';
import { useState } from "react";
import Header from "../components/Header";

// Função para converter "DD/MM/AAAA HH:MM:SS" para objeto Date
function parseBRDate(dateStr) {
  const [date, time] = dateStr.split(" ");
  const [day, month, year] = date.split("/");
  return new Date(`${year}-${month}-${day}T${time}`);
}

// Função para calcular duração em minutos
function getDurationInMinutes(startedAt, endedAt) {
  const start = parseBRDate(startedAt);
  const end = parseBRDate(endedAt);
  const diffMs = end - start;
  return Math.round(diffMs / 1000 / 60); // minutos
}

function HistoryRow({ item }) {
  return (
    <div key={item.id} className="flex justify-between items-center border-b py-2 text-sm text-gray-800">
        <div className="flex w-full">
            <span className="w-1/10">#{item.travelId}</span>
            <span className="w-1/4">{item.startedAt}</span>
            <span className="w-1/4">{item.endedAt}</span>
            <span className="w-1/4">{getDurationInMinutes(item.startedAt, item.endedAt)} min</span>
            <span className="w-1/10">R$ {item.price.toFixed(2)}</span>
        </div>
    </div>
  );
}

function UserPage() {
  const itemsPerPage = 5;
  const [currentPage, setCurrentPage] = useState(1);

  const totalPages = Math.ceil(userInfo.travels.length / itemsPerPage);
  const paginatedData = userInfo.travels.slice(
    (currentPage - 1) * itemsPerPage,
    currentPage * itemsPerPage
  );

  return (
    <div className="h-full flex flex-col items-center relative">
      <Header 
        leftIcon={
          <Link to={"/home"}>
            <RiArrowLeftLine color="black" size="20" />
          </Link>
        }
      />

      <section className="my-12 text-black w-3/4 flex items-center pl-10 pr-10">
            <FaUserCircle color="black" size="200" />
            <p className="text-3xl font-bold text-left pl-10">{userInfo.name}</p>
      </section>

      <section className="my-2 text-black w-3/4">
        <p className="text-l font-semibold mb-4 text-left pl-4">Informações gerais</p>

        <div className="flex gap-4">
          <div className="flex-1 p-4 flex flex-col">
            <TextField
              style={{margin: "10px 0"}}
              className="my-2"
              id="userName"
              label="Nome de usuário"
              value={userInfo.name}
              variant="filled"
              disabled
            />
            <TextField
              style={{margin: "10px 0"}}
              className="my-2"
              id="userEmail"
              label="E-mail"
              value={userInfo.email}
              variant="filled"
              disabled
            />
          </div>
          <div className="flex-1 p-4 flex flex-col">
            <TextField
              style={{margin: "10px 0"}}
              className="my-2"
              id="userBirthDate"
              label="Data de nascimento"
              value={userInfo.birthDate}
              variant="filled"
            />
            <TextField
              style={{margin: "10px 0"}}
              className="my-2"
              id="userCourse"
              label="Curso"
              value={userInfo.course}
              variant="filled"
            />
          </div>
        </div>
      </section>

      <section className="my-2 text-black w-3/4">
        <p className="text-l font-semibold mb-4 text-left pl-4">Histórico de viagens</p>

        <div className="mb-10">
            <div className="flex justify-between font-semibold text-gray-600 border-b pb-2 text-sm">
                <span className="w-3/20">ID da viagem</span>
                <span className="w-4/20">Início</span>
                <span className="w-4/20">Fim</span>
                <span className="w-2/20">Duração (min)</span>
                <span className="w-4/20 text-right">Preço</span>
                <span className="w-3/20 text-center"></span>
            </div>

            {paginatedData.map((item) => (
                <div key={item.id} className="flex justify-between font-semibold text-gray-600 border-b pb-2 text-sm">
                  <span className="w-3/20">{item.travelId}</span>
                  <span className="w-4/20">{item.startedAt}</span>
                  <span className="w-4/20">{item.endedAt}</span>
                  <span className="w-2/20">{getDurationInMinutes(item.startedAt, item.endedAt)} min</span>
                  <span className="w-4/20 text-right">R$ {item.price.toFixed(2)}</span>
                  <span className="w-3/20 text-center">
                    <Link 
                      to={`/evaluate/${item.travelId}`} 
                      className="ml-4 text-blue-600 hover:underline"
                    >
                      Avaliar
                    </Link>
                  </span>
                  
                </div>
            ))}

            {/* Paginação */}
            <div className="flex justify-between items-center mt-6">
                <button
                onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
                disabled={currentPage === 1}
                className="px-3 py-1 bg-blue-500 text-white rounded disabled:opacity-50"
                >
                Anterior
                </button>
                <span>Página {currentPage} de {totalPages}</span>
                <button
                onClick={() => setCurrentPage((prev) => Math.min(prev + 1, totalPages))}
                disabled={currentPage === totalPages}
                className="px-3 py-1 bg-blue-500 text-white rounded disabled:opacity-50"
                >
                Próxima
                </button>
            </div>
        </div>
      </section>
    </div>
  );
}

export default UserPage;

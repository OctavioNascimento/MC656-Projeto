export const userTravels = [
    {
        travelId: 116,
        startedAt: '14/05/2025 18:51:32',
        endedAt: '14/05/2025 18:58:44',
        bikeId: 32,
        price: 1.50
    },
    {
        travelId: 136,
        startedAt: '16/05/2025 19:14:06',
        endedAt: '16/05/2025 19:32:12',
        bikeId: 46,
        price: 4.50
    },
    {
        travelId: 139,
        startedAt: '17/05/2025 18:49:25',
        endedAt: '17/05/2025 19:02:51',
        bikeId: 32,
        price: 3
    },
    {
        travelId: 145,
        startedAt: '17/05/2025 22:19:45',
        endedAt: '17/05/2025 22:32:58',
        bikeId: 32,
        price: 4.50
    },
    {
        travelId: 202,
        startedAt: '20/05/2025 12:15:16',
        endedAt: '20/05/2025 19:04:58',
        bikeId: 32,
        price: 13.50
    },
    {
        travelId: 211,
        startedAt: '20/05/2025 22:02:45',
        endedAt: '20/05/2025 22:14:18',
        bikeId: 32,
        price: 3
    }
]

export const userInfo = {
    id: 316417913,
    name: "Humberto Ferreira da Silva",
    email: "h144587@dac.unicamp.br", 
    birthDate: "24/02/1998",
    course: "Ciência da Computação",
    travels: userTravels
}

export function getTravelById(id){
    for (var i = 0; i < userTravels.length; i++){
        if (userTravels[i].travelId == id){
            return userTravels[i]
        }
    }
    return {}
}

// Função para converter "DD/MM/AAAA HH:MM:SS" para objeto Date
export function parseBRDate(dateStr) {
  const [date, time] = dateStr.split(" ");
  const [day, month, year] = date.split("/");
  return new Date(`${year}-${month}-${day}T${time}`);
}

// Função para calcular duração em minutos
export function getDurationInMinutes(startedAt, endedAt) {
  const start = parseBRDate(startedAt);
  const end = parseBRDate(endedAt);
  const diffMs = end - start;
  return Math.round(diffMs / 1000 / 60); // minutos
}
import { RiArrowLeftLine } from "react-icons/ri";
import { useNavigate, Link, useLocation } from "react-router-dom";
import { getDurationInMinutes, getTravelById } from "../mocks/mocks";
import Header, { headerIconsSize } from "../components/Header";
import { FaUserCircle } from "react-icons/fa";
import { Alert, AlertTitle, Backdrop, Box, CircularProgress, Rating, Snackbar, TextField, Typography } from "@mui/material";
import Button from "../components/Button";
import { useState } from "react";

function ReviewPage() {
  const navigate = useNavigate()
  const travelId = useLocation().pathname.split('/')[2]
  const travel = getTravelById(travelId)

  const [travelRate, setTravelRate] = useState(0);
  const [bikeRate, setBikeRate] = useState(0);
  const [comment, setComment] = useState('');

  const [successSnackBar, setSuccessSnackBar] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleCloseSnack = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setSuccessSnackBar(false);
  };

  const onClickButton = () => {
    setLoading(true);

    setTimeout(() => {
      setLoading(false);
      window.scrollTo({ top: 0 });
      setSuccessSnackBar(true);
    }, 1000); // 1 segundo
  };

  return (
    <div className="h-full flex flex-col items-center relative">
      <Header 
        leftIcon={
            <Link to={'..'} onClick={(e) => {
                e.preventDefault();
                navigate(-1);
                }}>
            <RiArrowLeftLine color="black" size={headerIconsSize} />
            </Link>
        }
      />
      
      <section className="my-2 text-black w-full">
        <p className="text-l font-semibold mb-4 mt-10 text-left pl-4">Avaliação</p>

        {travel.travelId? 
          <>
            <div className="p-6 bg-white rounded-2xl shadow-md mx-auto w-full">
              <h2 className="text-xl font-semibold text-gray-800 mb-4">
                Resumo da viagem #{travel.travelId}
              </h2>
              <ul className="list-disc list-inside space-y-2 text-gray-700">
                <li>
                  <strong>Início:</strong> {travel.startedAt}
                </li>
                <li>
                  <strong>Fim:</strong> {travel.endedAt}
                </li>
                <li>
                  <strong>Duração (em min):</strong> {getDurationInMinutes(travel.startedAt, travel.endedAt)} minutos
                </li>
                <li>
                  <strong>Preço:</strong> R$ {travel.price.toFixed(2)}
                </li>
                <li>
                  <strong>Bicicleta utilizada:</strong> Bicicleta #{travel.bikeId}
                </li>
              </ul>
            </div>

            <div className="flex w-full flex-col">
              <div className="flex items-center mb-2 mt-4">
                <p className="text-base text-left pl-4 pr-4 w-1/2">Avaliação da viagem:</p>
                <Rating
                  name="simple-controlled"
                  value={travelRate}
                  onChange={(event, newValue) => {
                    setTravelRate(newValue);
                  }}
                  size="large"
                />
              </div>
              
              <div className="flex items-center mb-4 mt-2">
                <p className="text-base text-left pl-4 pr-4 w-1/2">Avaliação da bicicleta utilizada:</p>
                <Rating
                  name="simple-controlled"
                  value={bikeRate}
                  onChange={(event, newValue) => {
                    setBikeRate(newValue);
                  }}
                  size="large"
                />
              </div>

              <TextField
                label="Comentário"
                multiline
                minRows={3}
                variant="outlined"
                value={comment}
                onChange={(event, newComment) => setComment(newComment)}
                fullWidth
              />
            </div>
            
            <div className="flex items-center justify-center m-10">
              <Button
                value="Enviar avaliação"
                onClick={onClickButton}
                className="
              border p-2 w-70 rounded-md 
              bg-cyan-600 hover:bg-cyan-700 
              font-bold hover:cursor-pointer active:bg-cyan-700 items-center text-white"
              />
            </div>
          </>
          : <></>
        }
        
      </section>

      <Backdrop open={loading} style={{ zIndex: 1300, color: '#fff' }}>
        <CircularProgress color="inherit" />
      </Backdrop>

      <Snackbar open={successSnackBar} autoHideDuration={2000} onClose={handleCloseSnack}>
        <Alert
          onClose={handleCloseSnack}
          severity="success"
          variant="filled"
          sx={{ width: '100%' }}
        >
          Avaliação enviada com sucesso!
        </Alert>
      </Snackbar>
    </div>
  );
}

export default ReviewPage;

import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';

const CustomButton = styled(Button, {
  shouldForwardProp: (prop) => prop !== 'width' && prop !== 'height',
})(({ width, height }) => ({
  width: width || '200px',
  height: height || '3.5rem',
  padding: '1rem',
  borderRadius: '1rem',
  backgroundColor: '#0891b2',
  color: '#fff',
  fontWeight: 'bold',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  gap: '0.5rem',
  border: '1px solid transparent',

  '&:hover': {
    backgroundColor: '#0e7490',
  },
  '&:active': {
    backgroundColor: '#0e7490',
  },
}));

export default function ContainedButton({ onClick, children, width, height, disabled }) {
  return (
    <CustomButton onClick={onClick} variant='contained' width={width} height={height} disabled={disabled}>
      {children}
    </CustomButton>
  );
}

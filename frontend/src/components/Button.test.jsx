import { render, screen } from '@testing-library/react'
import ContainedButton from './Button'

test('Should render a button with text "LOGIN"', () => {
     render(<ContainedButton>LOGIN</ContainedButton>)
     expect(screen.getByText('LOGIN')).toBeInTheDocument()
})
